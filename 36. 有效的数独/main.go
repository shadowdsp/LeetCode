func isValidSudoku(board [][]byte) bool {
    n := len(board)
    if n <= 0 {
        return true
    }
    m := len(board[0])
    if m <= 0 {
        return true
    }
    for i := 0; i < n; i++ {
		st := 0
        for j := 0; j < m; j++ {
            if board[i][j] == []byte(".")[0] {
                continue;
			}
			c := uint(board[i][j] - []byte("0")[0])
            if (st & (1 << c)) > 0 {
				return false
			}
			st |= (1 << c)
        }
    }
    for j := 0; j < m; j++ {
		st := 0
        for i := 0; i < n; i++ {
            if board[i][j] == []byte(".")[0] {
                continue;
            }
			c := uint(board[i][j] - []byte("0")[0])
            if (st & (1 << c)) > 0 {
				return false
			}
			st |= (1 << c)
        }
	}
	
	for x := 0; x < 3; x++ {
		for y := 0; y < 3; y++ {
			st := 0
			for i := 3 * x; i < 3 * (x + 1); i++ {
				for j := 3 * y; j < 3 * (y + 1); j++ {
					if board[i][j] == []byte(".")[0] {
						continue;
					}
					c := uint(board[i][j] - []byte("0")[0])
					if (st & (1 << c)) > 0 {
						return false
					}
					st |= (1 << c)
				}
			}
		}
	}

    return true;
}