/*
 * Copyright 2016 geoint.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.geoint.java.function;

import org.junit.Test;

/**
 * Tests {@link ThrowingFunction} default method logic.
 *
 * @author steve_siebert
 */
public class ThrowingFunctionTest {

    @Test
    public void testAfterChaining() throws Exception {
        final String ordinalSource = "1";
       
    }

    @Test
    public void testBeforeChaining() throws Exception {

    }

    
    private <V> TestEnum getOrdinal(ThrowingFunction<V, TestEnum, ArrayIndexOutOfBoundsException> parser)
            throws ArrayIndexOutOfBoundsException {
        
    }

    enum TestEnum {
        FIRST, SECOND, THIRD;

        public static TestEnum ordinalValue(int ordinal)
                throws ArrayIndexOutOfBoundsException {
            return TestEnum.values()[ordinal];
        }
    }

}
