package Lesson14.HomeWork.FirstTask;

import java.lang.reflect.Method;

/**
 * Created by user on 28.08.16.
 */
public final class Arguments {
    private final Method methods;

    private final Object[] arguments;

    private final int hashCode;

    public Arguments(final Method m, final Object[] args) {
        methods = m;
        arguments = args;
        hashCode = calculateHash();
    }

    @Override
    public boolean equals(final Object obj) {
        final Arguments other = (Arguments) obj;
        if (!methods.equals(other.methods)) {
            return false;
        }
        for (int i = 0; i < arguments.length; ++i) {
            Object o1 = arguments[i];
            Object o2 = other.arguments[i];
            if (!(o1 == null ? o2 == null : o1.equals(o2))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }


    public int calculateHash() {
        int h = methods.hashCode();
        for (final Object o : arguments) {
            h = h * 12345 + (o == null ? 0 : o.hashCode());
        }
        return h;
    }
}