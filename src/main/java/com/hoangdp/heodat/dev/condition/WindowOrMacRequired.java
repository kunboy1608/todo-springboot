package com.hoangdp.heodat.dev.condition;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;

public class WindowOrMacRequired extends AnyNestedCondition {

    public WindowOrMacRequired(ConfigurationPhase configurationPhase) {
        super(ConfigurationPhase.REGISTER_BEAN);
    }
    
    public WindowOrMacRequired() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @ConditionalOnWindow
    static class RunOnWindow {
    }

    @Conditional(MacRequired.class)
    static class RunOnMac {
    }

}
