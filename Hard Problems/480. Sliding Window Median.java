class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new double[0];
        
        Node root = null;
        for (int i = 0; i < k; i++) {
            root = insert(root, nums[i]);
        }
        
        double[] r = new double[nums.length - k + 1];
        boolean even = k % 2 == 0;
        int j = 0;
        for (int i = k; i <= nums.length; i++) {
            double sum = 0.0;
            if (even)
                sum = (findSmallest(root, k/2).val + findSmallest(root, k/2 + 1).val) / 2.0;
            else
                sum = findSmallest(root, k/2 + 1).val;
            r[j++] = sum;
            if (i < nums.length) {
                root = insert(root, nums[i]);
                root = delete(root, nums[i - k]);
            }
        }
        
        return r;
    }
    
    private Node findSmallest(Node root, int k) {
        int s = countWith(root.left) + 1;
        if (s == k)
            return root;
        if (s > k) {
            return findSmallest(root.left, k);
        }
        return findSmallest(root.right, k - s);
    } 
  
    private Node delete(Node root, long val) {
        if (root == null)
            return null;
        else if (val > root.val) 
            root.right = delete(root.right, val);
        else if (val < root.val)
            root.left = delete(root.left, val);
        else {
            if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                Node t = findMin(root.right);
                root.val = t.val;
                root.right = delete(root.right, t.val);
            }
        }
        
        return updateNode(root);
    }
    
    private Node findMin(Node root) {
        if (root.left != null)
            return findMin(root.left);
        return root;
    }

    private Node insert(Node root, long val)
    {
        if (root == null)
        {
            return new Node(val);
        }
        if (val >= root.val)
        {
            root.right = insert(root.right, val);
        }
        else
        {
            root.left = insert(root.left, val);
        }
       
        return updateNode(root);
    }
    
    private Node updateNode(Node root) {
        int b = balance(root); 		
        if (b == 2 && balance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        }
        else if (b == -2 && balance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        }
        else if (b == 2)
        {
            root = rightRotate(root);
        }
        else if (b == -2)
        {
            root = leftRotate(root);
        }
        update(root);
        return root;
    }

    private Node leftRotate(Node n)
    {
        Node r = n.right;
        n.right = r.left;
        r.left = n;
        update(n);
        update(r);
        return r;
    }

    private Node rightRotate(Node n)
    {
        Node l = n.left;
        n.left = l.right;
        l.right = n;
        update(n);
        update(l);
        return l;
    }

    private int balance(Node n)
    {
        if (n==null)return 0;
        return height(n.left) - height(n.right);
    }

    private void update(Node n)
    {
        if (n==null)return;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        n.count = n.left != null ? n.left.count + 1 : 0;
        n.count += n.right != null ? n.right.count + 1 : 0;
    }

    private int height(Node n)
    {
        return n != null ? n.height : 0;
    }

    private int countWith(Node n)
    {
        return n != null ? n.count + 1 : 0;
    }

    static class Node
    {
        Node left;
        Node right;
        long val;
        int count;
        int height;

        Node(long val)
        {
            this.val = val;
        }
    }
}