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

import java.util.function.Function;

/**
 * Represents a function that accepts one argument, ideally produces a result,
 * or throws a Throwable exception if the function fails to produce a result
 * (pre-conditions not met, external dependencies not met, whatever your
 * pleasure).
 *
 * @see Function
 * @author steve_siebert
 * @param <T> type to be transformed
 * @param <R> type returned
 * @param <X> exception type that may be thrown
 */
@FunctionalInterface
public interface ThrowingFunction<T, R, X extends Throwable> {

    /**
     * Invokes this function on the provided argument, returning the results of
     * throwing the exception.
     *
     * @param t function arg
     * @return function results
     * @throws X if the function fails to complete
     */
    public R apply(T t) throws X;

    /**
     * Returns a function which, when invoked, executes this function than the
     * <i>after</i> function.
     *
     * @see Function#andThen(java.util.function.Function)
     * @param <V> output type of the after function, resulting from applying the
     * results of this function
     * @param after function to invoke on the results of this function
     * @return chained function
     * @throws X exception type that may be thrown by executing this chain
     */
    public default <V> ThrowingFunction<T, V, ? extends X> andThen(
            ThrowingFunction<? super R, ? extends V, ? extends X> after)
            throws X {
        return (t) -> after.apply(this.apply(t));
    }

    /**
     * Returns a function which, when invoked, executes the <i>before</i>
     * function than executes this function.
     *
     * @see Function#compose(java.util.function.Function)
     * @param <V> function to invoke first, the results of which are provided to
     * this function
     * @param before function to invoke to provide the argument for this
     * function
     * @return chained function
     * @throws X exception type that may be thrown by executing this chain
     */
    public default <V> ThrowingFunction<V, R, ? extends X> compose(
            ThrowingFunction<? super V, ? extends T, ? extends X> before)
            throws X {
        return (v) -> this.apply(before.apply(v));
    }

}
