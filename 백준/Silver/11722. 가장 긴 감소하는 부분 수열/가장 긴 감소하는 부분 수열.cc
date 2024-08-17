#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int solution(vector<int> seq)
{
	int n = seq.size();
	vector<int> seq_len(n);
	int m = 1;
	for (int i = n - 1; i >= 0; i--)
	{
		seq_len[i] = 1;
		for (int j = i + 1; j < n; j++)
		{
			if ((seq[i] > seq[j]) && (seq_len[i] <= seq_len[j]))
			{
				seq_len[i] = seq_len[j] + 1;
				if (seq_len[i] > m) m = seq_len[i];
			}
		}
	}
	return m;
}

int main() 
{
	int n, num;
	cin >> n;
	vector<int> nums;
	for (int i = 0; i < n; i++)
	{
		cin >> num;
		nums.push_back(num);
	}
	cout << solution(nums) << endl;
	return 0;
}