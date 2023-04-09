package org.example.common.spring.boot.exceptions.base;

/**
 * <b><code>AbstractAssert</code></b>
 * <p/>
 * 异常断言接口默认实现类， 由于枚举不能继承，所以不能使用抽象类
 * <p/>
 * <b>Creation Time:</b> 2022/8/24 上午11:51.
 *
 * @author yang xiong
 */
public interface IBaseAssert extends IExceptionFactory, IAssert {
    @Override
    default void assertNotNull(Object obj) throws BaseException {
        if (obj == null) {
            throw newException(obj);
        }
    }

    @Override
    default void assertNotNull(Object obj, Object... args) throws BaseException {
        if (obj == null) {
            throw newException(args);
        }
    }

    @Override
    default void assertFalse(Boolean obj) throws BaseException {
        if (!Boolean.FALSE.equals(obj)) {
            throw newException(obj);
        }
    }

    @Override
    default void assertFalse(Boolean obj, Object... args) throws BaseException {
        if (!Boolean.FALSE.equals(obj)) {
            throw newException(args);
        }
    }
}