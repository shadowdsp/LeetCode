/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }
    fir := &ListNode{head.Val - 1, head}
    cur := fir
    nxt := head
    count := 0
    for nxt != nil {
        count++
        nn := nxt.Next
        if nn == nil {
            break
        }
        if nxt.Val != nn.Val {
            if count > 1 {
                cur.Next = nn
            } else {
                cur = cur.Next
            }
            count = 0
        }
        nxt = nn
    }
    if count > 1 {
        cur.Next = nil
    }
    return fir.Next
}