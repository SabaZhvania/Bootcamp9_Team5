package ge.tbcitacademy.steps;

import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.util.RandomPassUtil;

import java.util.ArrayList;
import java.util.List;

public class TimingAtackSteps {
    private SignInSteps signInSteps;
    private StaysSteps staysSteps;
    private List<Long> responseTimes;

    public TimingAtackSteps() {
        signInSteps = new SignInSteps();
        staysSteps = new StaysSteps();
        responseTimes = new ArrayList<>();
    }

    public TimingAtackSteps initializeSteps() {
        signInSteps = new SignInSteps();
        staysSteps = new StaysSteps();
        return this;
    }

//    public TimingAtackSteps closeSignInPopUp() {
//        staysSteps.closeSignInPopUp();
//        return this;
//    }

    public TimingAtackSteps generateAndEnterPassword() {
        String incorrectPassword = RandomPassUtil.generateRandomPassword();
        signInSteps.enterPassword(incorrectPassword);
        return this;
    }

    public TimingAtackSteps measureResponseTime() {
        long startTime = System.currentTimeMillis();
        signInSteps.clickSignInButtonOnSignInPage();
        long endTime = System.currentTimeMillis();
        responseTimes.add(endTime - startTime);
        return this;
    }

    public TimingAtackSteps performAttack() {
        int n_of_attembpts = Constants.TIMING_ATACK_NUM;
        for (int i = 0; i < n_of_attembpts; i++) {
            generateAndEnterPassword().measureResponseTime();
        }
        return this;
    }

    public TimingAtackSteps validateConsistency() {
        double averageResponseTime = responseTimes.stream().mapToLong(Long::longValue).average().orElse(0.0);
        boolean timingConsistent = responseTimes.stream().allMatch(time -> Math.abs(time - averageResponseTime) < 100);
        assert timingConsistent : Constants.TIMING_ATACK_ERROR;
        return this;
    }
}
