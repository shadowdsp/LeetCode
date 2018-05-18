/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func insertionSortList(head *ListNode) *ListNode {
    dummy := &ListNode{0, head}
    pp, cur := dummy, head
    for cur != nil {
        tmp := cur.Next
        pre, now := dummy, dummy.Next
        for now != cur {
            if cur.Val < now.Val {
                break
            }
            pre = now
            now = now.Next 
        }
        if now != cur {
            pre.Next = cur
            cur.Next = now
            pp.Next = tmp
        }
        for pp = now ; pp.Next != tmp; pp = pp.Next {
            
        }
        cur = tmp
    }
    return dummy.Next
}