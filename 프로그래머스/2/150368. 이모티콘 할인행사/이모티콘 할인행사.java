class Solution {
    int maxJoin = 0;
    int maxPrice = 0;
    int[] discounts = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        findBest(0, new int[emoticons.length], users, emoticons);
        return new int[]{maxJoin, maxPrice};
    }

    private void findBest(int depth, int[] currentDiscounts, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            int join = 0;
            int price = 0;

            for (int[] user : users) {
                int userRate = user[0];
                int userLimit = user[1];
                int total = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (currentDiscounts[i] >= userRate) {
                        total += emoticons[i] * (100 - currentDiscounts[i]) / 100;
                    }
                }

                if (total >= userLimit) join++;
                else price += total;
            }

            // 가입자 수가 더 많거나, 가입자 수가 같을 때 금액이 더 크면 갱신
            if (join > maxJoin) {
                maxJoin = join;
                maxPrice = price;
            } else if (join == maxJoin) {
                maxPrice = Math.max(maxPrice, price);
            }
            return;
        }

        // 4가지 할인율 적용 (재귀)
        for (int rate : discounts) {
            currentDiscounts[depth] = rate;
            findBest(depth + 1, currentDiscounts, users, emoticons);
        }
    }
}