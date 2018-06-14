/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.common;

/**
 *
 * @author trungchanh
 */
public class Constants {

    public static enum TargetType {
        REQUESTER(0),
        USER(1),
        USER_GROUP(2);

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }

        private final int value;

        private TargetType(int type) {
            this.value = type;
        }

    }

    public static enum StateType {
        START(1),
        NORMAL(2),
        COMPLETED(3),
        CANCELLED(4);

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }

        private final int value;

        private StateType(int type) {
            this.value = type;
        }

    }
}
