func isMonotonic(A []int) bool {
	inc, des := true, true
	for i := 1; i < len(A); i++ {
		if A[i] < A[i-1] {
			inc = false
		}
		if A[i] > A[i-1] {
			des = false
		}
	}
	return inc || des
}