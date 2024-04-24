package buffer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConcurrentCircularBuffer<T> {
    private T[] buffer;
    private int bufferSize;
    private int currentSize;
    private int readIndex = 0;
    private int writeIndex = 0;
    private Lock lock = new ReentrantLock();

    public ConcurrentCircularBuffer(int size) {
        bufferSize = size;
        buffer = (T[]) new Object[bufferSize];
        currentSize = 0;
    }

    public void writeData(T data) throws BufferFullException {
        try {
            lock.lock();
            if (currentSize == bufferSize) {
                throw new BufferFullException();
            }
            buffer[writeIndex] = data;
            writeIndex = (writeIndex + 1) % bufferSize;
            currentSize++;
        } finally {
            lock.unlock();
        }
    }

    public T readData() throws EmptyBufferException {
        try {
            lock.lock();
            if (currentSize == 0) {
                throw new EmptyBufferException();
            }
            T result = buffer[readIndex];
            readIndex = (readIndex + 1) % bufferSize;
            currentSize--;
            return result;
        } finally {
            lock.unlock();
        }
    }
}
