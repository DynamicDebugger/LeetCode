class MinStack {
    Node head;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null){
            Node newNode = new Node(val, val);
            head = newNode;
        }else{
            int min = Math.min(head.min, val);
            Node newNode = new Node(val, min);
            newNode.next = head;
            head = newNode;

        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
class Node{
    int val;
    int min;
    Node next;
    Node(int val, int min){
        this.val = val;
        this.min = min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */