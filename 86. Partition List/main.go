/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func partition(head *ListNode, x int) *ListNode {
    h1 := &ListNode{0, nil}
    h2 := &ListNode{0, nil}
    cur1 := h1
    cur2 := h2
    for cur := head; cur != nil; {
        if cur.Val < x {
            cur1.Next = cur
            cur1 = cur1.Next
            cur = cur.Next
            cur1.Next = nil
        } else {
            cur2.Next = cur
            cur2 = cur2.Next
            cur = cur.Next
            cur2.Next = nil
        }
    }
    if h2.Next != nil {
        cur1.Next = h2.Next
    }
    return h1.Next
}