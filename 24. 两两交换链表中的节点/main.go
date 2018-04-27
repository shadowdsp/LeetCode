/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func swapPairs(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }
    now := head
	next := now.Next
    pre := head
    for next != nil {
		pre.Next = next
        nnext := next.Next
		next.Next = now
        if head == now {
            head = next
        }
		now.Next = nnext
		pre = now
        
        now = now.Next
        if now == nil {
            break
		}
		next = now.Next
    }
    return head
}