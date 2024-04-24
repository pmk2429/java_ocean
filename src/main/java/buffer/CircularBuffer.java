package buffer;

public class CircularBuffer<T> {
    private T[] buffer;
    private final int CAPACITY;
    private int currentSize;
    private int readIndex = 0;
    private int writeIndex = 0;

    public CircularBuffer(int size) {
        CAPACITY = size;
        buffer = (T[]) new Object[CAPACITY];
        currentSize = 0;
    }

    public void writeData(T data) throws BufferFullException {
        if (currentSize == CAPACITY) {
            throw new BufferFullException();
        }
        buffer[writeIndex] = data;
        writeIndex = (writeIndex + 1) % CAPACITY;
        currentSize++;
    }

    public T readData() throws EmptyBufferException {
        if (currentSize == 0) {
            throw new EmptyBufferException();
        }
        T result = buffer[readIndex];
        readIndex = (readIndex + 1) % CAPACITY;
        currentSize--;
        return result;
    }
}

class BufferFullException extends Exception {
    public BufferFullException() {
        super("The buffer is full.");
    }
}

class EmptyBufferException extends Exception {
    public EmptyBufferException() {
        super("The buffer is empty.");
    }
}
