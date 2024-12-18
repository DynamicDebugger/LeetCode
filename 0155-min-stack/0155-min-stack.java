class MinStack {
    Node head;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null){
            Node newNode = new Node(val, val, null);
            head = newNode;
        }else{
            int min = Math.min(head.min, val);
            Node newNode = new Node(val, min, head);
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
    Node(int val, int min, Node next){
        this.val = val;
        this.min = min;
        this.next = next;
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