class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {

        int m = series1.length;
        int n = series2.length;

        List<List<Integer>> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            if (series1[i][0] < series2[j][0]) {
                ans.add(List.of(
                    series1[i][0],
                    series1[i][1] + series2[j][1]
                ));

                i++;
            }
            else if (series1[i][0] > series2[j][0]) {
                ans.add(List.of(
                    series2[j][0],
                    series1[i][1] + series2[j][1]
                ));

                j++;
            }
            else {
                ans.add(List.of(
                    series1[i][0],
                    series1[i][1] + series2[j][1]
                ));

                i++;
                j++;
            }
        }

        while (i < m) {
            ans.add(List.of(
                series1[i][0],
                series1[i][1]
            ));
            i++;
        }

        while (j < n) {
            ans.add(List.of(
                series2[j][0],
                series2[j][1]
            ));
            j++;
        }

        return ans;
    }
}
