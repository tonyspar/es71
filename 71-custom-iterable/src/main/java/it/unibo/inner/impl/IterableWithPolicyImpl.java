package it.unibo.inner.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private final T[] elements;

    

    public IterableWithPolicyImpl(final T[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    private class TIterator implements Iterator<T>{

        int i=0;

        @Override
        public boolean hasNext() {
             return i < IterableWithPolicyImpl.this.elements.length;
        }

        @Override
        public T next() {
            if(hasNext()){
                return IterableWithPolicyImpl.this.elements[i++];
            } else {
                throw new NoSuchElementException();
            }
        }
        
    }

    @Override
    public Iterator<T> iterator() {
       return new TIterator();
    }

    @Override
    public void setIterationPolicy(Predicate filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }
    
}
