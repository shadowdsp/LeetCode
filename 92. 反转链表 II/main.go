/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func reverseBetween(head *ListNode, m int, n int) *ListNode {
    dummy := &ListNode{0, head}
    if head == nil || m == n || head.Next == nil {
        return head
    }
    pre, cur, nxt := dummy, head, head.Next
    cnt := 1
    for cnt < m && cur != nil {
        cnt++
        pre = cur
        cur = cur.Next
    }
    h := pre
    hh := pre.Next
    for cnt <= n && cur != nil {
        cnt++
        nxt = cur.Next
        cur.Next = pre
        pre = cur
        cur = nxt
    }
    h.Next = pre
    hh.Next = cur
    return dummy.Next
}