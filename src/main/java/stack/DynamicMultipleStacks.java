package stack;

public class DynamicMultipleStacks {
    private int stackSize;
    private int numOfStacks;
    private int indexUsed = 0;
    private int[] buffer;
    private int[] stackPointer;

    public DynamicMultipleStacks(int stackSize, int numOfStacks) {
        this.stackSize = stackSize;
        this.numOfStacks = numOfStacks;
        buffer = new int[stackSize * 3];
        stackPointer = new int[numOfStacks];
        for (int i = 0; i < numOfStacks; i++) {
            stackPointer[i] = 0;
        }
    }

    public void push(int stackNum, int value) {
        int index = stackNum * stackSize + stackPointer[stackNum] + 1;
        stackPointer[stackNum]++;
        buffer[index] = value;
    }

    public int pop(int stackNum) {
        int index = stackNum * stackSize + stackPointer[stackNum];
        stackPointer[stackNum]--;
        int value = buffer[index];
        buffer[index] = 0;
        return value;
    }

    public int peek(int stackNum) {
        int index = stackNum * stackSize + stackPointer[stackNum];
        return buffer[index];
    }

    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == stackNum * stackSize;
    }

}
