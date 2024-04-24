package stack;

public class MultipleStacks {
    private int stackSize;
    private int numOfStacks;
    private int[] buffer;
    private int[] stackPointer;

    public MultipleStacks(int stackSize, int numOfStacks) {
        this.stackSize = stackSize;
        this.numOfStacks = numOfStacks;
        buffer = new int[stackSize * 3];
        stackPointer = new int[numOfStacks];
        for (int i = 0; i < numOfStacks; i++) {
            stackPointer[i] = 0;
        }
    }

    /**
     * <h1>push</h1>
     *
     * @param stackNum
     * @param value
     */
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

    public static void main(String[] args) {
        MultipleStacks stacks = new MultipleStacks(10, 3);
        stacks.push(2, 15);
        stacks.push(2, 24);
        stacks.push(1, 12);
        stacks.push(1, 88);
        stacks.push(1, 74);
        stacks.push(0, 2429);
        stacks.push(0, 98);
    }

}