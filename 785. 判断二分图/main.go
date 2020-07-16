// 二分图染色

func dfs(graph [][]int, u, val int, color []int) bool {
    if color[u] != 0 {
        return color[u] == val
    }
    color[u] = val
    for i := 0; i < len(graph[u]); i++ {
        if !dfs(graph, graph[u][i], -val, color) {
            return false
        }
    }
    return true
}

func isBipartite(graph [][]int) bool {
    n := len(graph)
    if n <= 0 {
        return true
    }
    color := make([]int, n)
    for i := 0; i < n; i++ {
        if color[i] != 0 {
            continue
        }
        if !dfs(graph, i, 1, color) {
            return false
        }
    }
    return true
}