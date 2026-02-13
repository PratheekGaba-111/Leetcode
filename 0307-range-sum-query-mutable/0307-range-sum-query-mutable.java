
class NumArray {
    int[] tree;
    int[] lazy;
    int n;
    private void build(int[] tree,int[] ar, int node, int l, int r){
        if(l == r){
            tree[node] = ar[l];
        }
        else{
            int mid = l + (r - l)/2;
            build(tree, ar, 2 * node + 1, l, mid);
            build(tree, ar, 2 * node + 2, mid + 1, r);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }
    private void supdate(int node, int l, int r, int idx, int val){
        if(lazy[node] != 0){
            tree[node] += lazy[node];
            if(l != r){
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }
        if(l == r){
            tree[node] = val;
            return;
        }
        int mid = l + (r - l)/2;
        if(idx <= mid){
            supdate(2 * node + 1, l, mid, idx, val);
        }
        else{
            supdate(2 * node + 2, mid + 1, r, idx, val);
        }
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    private int search(int node, int strt, int end, int l, int r){
        if(lazy[node] != 0){
            tree[node] += lazy[node];
            if(l != r){
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }
        if(l > end || r < strt) return 0;
        if(l <= strt && end <= r) return tree[node];
        int mid = strt + (end - strt)/2;
        int ls = search(2 * node + 1, strt, mid, l, r);
        int rs = search(2 * node + 2, mid + 1, end, l, r);
        return ls + rs;
    }
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.tree = new int[4 * n];
        this.lazy = new int[4 * n];
        build(tree, nums, 0, 0, n - 1);
    }
    
    public void update(int index, int val) {
        supdate(0, 0, n - 1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return search(0, 0, n - 1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */