package org.geoint.java.function;

import java.util.function.Supplier;

/**
 * Creates/instantiates a new instance of the object.
 *
 * This functional interface is similar to {@link Supplier} except this 
 * interface requires the returned type to be a new instance, whereby:
 * {@code 
 *      T first = Creator#instance();
 *      T second = Creator#instance();
 * 
 *      (first == second); //compare memory reference, returns false
 *      (first.equals(second)); //could return true or false
 *      (first.hashCode() == second.hashCode()); //could return true or false
 * }
 * 
 * The Creator functional interface is useful to when object instantiation need
 * to be deferred, for example, based on a conditional context or necessity.
 *
 * @param <T> type that is created
 * @see Supplier
 */
@FunctionalInterface
public interface Creator<T> {

    /**
     * Create the instance.
     *
     * @return instance
     */
    T instance();
}
