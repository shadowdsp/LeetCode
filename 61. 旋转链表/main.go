/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func rotateRight(head *ListNode, k int) *ListNode {
    if head == nil {
        return nil
    }
    cur, nxt, tail := head, head.Next, head
    n := 0
    for {
        n++
        if tail.Next == nil {
            break
        }
        tail = tail.Next
    }
    k = (n - k % n) % n
    fmt.Println(n, k)
    for k > 0 {
        nxt = cur.Next
        cur.Next = nil
        tail.Next = cur
        tail = tail.Next
        k--
        cur = nxt
    }
    return cur
}