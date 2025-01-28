public class Lowest
Common Ancestor
of a
Binary Tree III
{
    
    // Initially find the dept of each node to root and then move the nodes to equal depth initially, then from there move the nodes up until they are equal
    public int getDept(Node r) {
        int dep = 0;
        while (r != null) {
            r = r.parent;
            dep++;
        }
        return dep;
    }

    public Node lowestCommonAncestor(Node p, Node q) {

        int pDep = getDept(p);
        int qDep = getDept(q);

        while (pDep > qDep) {
            p = p.parent;
            pDep--;
        }
        while (qDep > pDep) {
            q = q.parent;
            qDep--;
        }

        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
}
