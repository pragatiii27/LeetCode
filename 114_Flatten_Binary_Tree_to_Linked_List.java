/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// Recursive Solution

// class Solution {
//     TreeNode prev = null;

//     public void flatten(TreeNode root) {
//         if(root == null) return;

//         flatten(root.right);
//         flatten(root.left);

//         root.right = prev;
//         root.left = null;

//         prev = root;  
//     }
// } 




// Iterative Solution

// class Solution {
//     public void flatten(TreeNode root) {
//         if(root == null) return;

//         Stack<TreeNode> st = new Stack<>();
//         st.push(root);

//         while(!st.isEmpty()) {
//             TreeNode curr = st.pop();

//             if(curr.right != null) {
//                 st.push(curr.right);
//             }

//             if(curr.left != null) {
//                 st.push(curr.left);
//             }
            
//             if(!st.isEmpty()) {
//                 curr.right = st.peek();
//             }
        
//             curr.left = null;
//         }
//     }
// } 




// Optimal Solution

class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while(curr != null) {
            if(curr.left != null) {
                TreeNode prev = curr.left;

                while(prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }
} 