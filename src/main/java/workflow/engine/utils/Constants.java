/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.utils;

/**
 *
 * @author trungchanh
 */
public class Constants {

    public static enum TargetType {
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
}
