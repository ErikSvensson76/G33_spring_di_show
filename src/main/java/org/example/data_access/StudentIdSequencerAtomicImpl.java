package org.example.data_access;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class StudentIdSequencerAtomicImpl implements StudentIdSequencer{

    private final AtomicInteger counter;

    public StudentIdSequencerAtomicImpl() {
        counter = new AtomicInteger(0);
    }

    @Override
    public int nextId() {
        return counter.incrementAndGet();
    }

    @Override
    public void clear() {
        counter.set(0);
    }

    public void setCounter(int number){
        counter.set(number);
    }
}
