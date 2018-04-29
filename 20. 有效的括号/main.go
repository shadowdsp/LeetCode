func isValid(s string) bool {
	stack := list.New()
	n := len(s)
    ans := true
    cnt := 0
    for i := 0; i < n; i++ {
        if s[i] == '(' || s[i] == '[' || s[i] == '{' {
            stack.PushBack(s[i])
            cnt++
        } else {
            if stack.Len() <= 0 {
                ans = false
                break
            }
			c := stack.Remove(stack.Back()).(byte)
            if s[i] == ']' && c == '[' || s[i] == ')' && c == '(' || s[i] == '}' && c == '{' {
                continue
            } else {
                ans = false
            }
        }
    }
    if cnt * 2 != n {
        ans = false
    }
    return ans
}