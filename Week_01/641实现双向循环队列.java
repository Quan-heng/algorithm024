/*
思路：
        capacity ; //队列长度
        front ;首指针
        rear ;尾指针
        size ;当前元素数量
*/
class MyCircularDeque {
    private int[] queue;
    private int capacity;
    private int front;
    private int rear;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        queue = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (size == 0 && front == 0) {
            queue[front] = value;
            size++;
            return true;
        }
        front = (front - 1 + capacity) % capacity;
        queue[front] = value;
        size++;
        return true;

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        }
        if (size == 0 && rear == 0) {
            queue[rear] = value;
            size++;
            return true;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            front = 0;
            queue[0] = -1;
        }else{
            front = (front + 1) % capacity;
        }
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            if (size == 1) {
                rear = 0;
                queue[0] = -1;
            } else {
                rear = (rear - 1 + capacity) % capacity;
            }
            size--;
            return true;
        }
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[front];
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[rear];
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */