/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseBetween(head *ListNode, m int, n int) *ListNode {
    cur := head
    var pre, nxt, h1, h2 *ListNode
    if cur == nil || n == m {
        return head
    }
    cnt := 0
    for {
        cnt++
        if cnt >= m {
            break
        }
        pre = cur
        cur = cur.Next
    }
    h1 = pre
    if h1 != nil {
        h2 = pre.Next
    }
    
    for cnt <= n {
        cnt++
        nxt = cur.Next
        cur.Next = pre
        pre = cur
        cur = nxt
    }
    
    if h1 != nil {
        h1.Next = pre
    } else {
        head.Next = cur
    }
    if h2 != nil {
        h2.Next = cur
    }
    
    if m != 1 {
        return head
    }
    return pre
}