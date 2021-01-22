package io.github.iomurphy.robot.support;

public interface SignAlgorithm<T, E> {

    T sign(E param) throws Exception;
}
