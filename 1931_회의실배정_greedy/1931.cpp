#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

#define pii pair<int,int>
#define MAX_N 100001
vector<pii> meets;

bool meetComp(pii& a, pii& b) {
	return a.second < b.second ||
		(a.second == b.second && a.first < b.first);
}

int main()
{
	int lineNum;
	scanf("%d", &lineNum);

	meets.clear();

	for (int i = 0; i < lineNum; i++) {
		int s, e;
		scanf("%d %d", &s, &e);
		meets.push_back({ s, e });
	}

	sort(meets.begin(), meets.end(), meetComp);

	int ret = 0;
	int n = 0;
	for (int i = 0; i < meets.size(); i++) {
		if (n <= meets[i].first) {
			n = meets[i].second;
			ret++;
		}
	}
	cout << ret << endl;
}