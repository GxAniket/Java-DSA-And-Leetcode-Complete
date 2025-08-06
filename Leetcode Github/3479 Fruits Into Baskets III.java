class SegmentTree {
    int[] tree;
    int n;

    SegmentTree(int[] baskets) {
        n = baskets.length;
        tree = new int[4 * n];
        build(baskets, 0, n - 1, 0);
    }

    void build(int[] baskets, int l, int r, int i) {
        if (l == r) {
            tree[i] = baskets[l];
            return;
        }
        int mid = (l + r) / 2;
        build(baskets, l, mid, 2 * i + 1);
        build(baskets, mid + 1, r, 2 * i + 2);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    void update(int index, int l, int r, int i) {
        if (l == r) {
            tree[i] = -1;
            return;
        }
        int mid = (l + r) / 2;
        if (index <= mid)
            update(index, l, mid, 2 * i + 1);
        else
            update(index, mid + 1, r, 2 * i + 2);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    int query(int fruit, int l, int r, int i) {
        if (tree[i] < fruit) return -1;
        if (l == r) return l;

        int mid = (l + r) / 2;
        int left = query(fruit, l, mid, 2 * i + 1);
        if (left != -1) return left;
        return query(fruit, mid + 1, r, 2 * i + 2);
    }
}

public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        SegmentTree st = new SegmentTree(baskets);
        int unplaced = 0;

        for (int fruit : fruits) {
            int idx = st.query(fruit, 0, n - 1, 0);
            if (idx == -1) {
                unplaced++;
            } else {
                st.update(idx, 0, n - 1, 0);
            }
        }

        return unplaced;
    }
}
