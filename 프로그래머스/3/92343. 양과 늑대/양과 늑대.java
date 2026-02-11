import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        int answer = 0;
        
        // 이진 트리 자식 노드 정리
        int[][] children = new int[n][2];
        for (int[] row : children) Arrays.fill(row, -1);
        for (int[] edge : edges) {
            if (children[edge[0]][0] == -1) children[edge[0]][0] = edge[1];
            else children[edge[0]][1] = edge[1];
        }

        // 중복 방문 방지: [현재위치][방문한 노드들의 비트마스크]
        boolean[][] visitedState = new boolean[n][1 << n];
        Deque<Info> queue = new ArrayDeque<>();

        // 초기 상태: 0번 노드 방문 (양 1, 늑대 0, 0번 노드 비트 켬)
        int startMask = 1 << 0;
        queue.add(new Info(0, 1, 0, startMask));
        visitedState[0][startMask] = true;

        while (!queue.isEmpty()) {
            Info cur = queue.poll();
            answer = Math.max(answer, cur.sheep);

            // 현재 상태에서 방문 가능한 후보군 계산
            for (int i = 0; i < n; i++) {
                // 이미 방문한 노드인 경우, 그 자식들을 후보로 검토
                if ((cur.mask & (1 << i)) != 0) {
                    for (int next : children[i]) {
                        if (next == -1) continue;
                        
                        // 이미 현재 비트 경로에 포함된 노드면 스킵
                        if ((cur.mask & (1 << next)) != 0) continue;

                        int nextSheep = cur.sheep + (info[next] == 0 ? 1 : 0);
                        int nextWolf = cur.wolf + (info[next] == 1 ? 1 : 0);

                        // 양이 늑대보다 많아야 이동 가능
                        if (nextSheep > nextWolf) {
                            int nextMask = cur.mask | (1 << next);
                            // 동일 위치 & 동일 방문 경로 상태가 아닐 때만 큐에 삽입
                            if (!visitedState[next][nextMask]) {
                                visitedState[next][nextMask] = true;
                                queue.add(new Info(next, nextSheep, nextWolf, nextMask));
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}

class Info {
    int loc, sheep, wolf, mask;
    public Info(int loc, int sheep, int wolf, int mask) {
        this.loc = loc;
        this.sheep = sheep;
        this.wolf = wolf;
        this.mask = mask;
    }
}