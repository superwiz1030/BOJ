#include <iostream>
#include <cstring>
#include <vector>

using namespace std;

#define log
#define MAX_N 100

vector<int> canGo[MAX_N];
int visit[MAX_N];
int gStart;
int gEnd;
int found;

void dfs(int idx) {
	if (visit[idx] && idx == gEnd) {
		found = 1;
		return;
	}

	if (!canGo[idx].empty()) {
		for (auto it : canGo[idx]) {
			if (!visit[it]) {
				visit[it] = 1;
				dfs(it);
			}
		}
	}
}

int main(void)
{
	int N;
	cin >> N;

	int v = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> v;
			if (v == 1) {
				canGo[i].push_back(j);
			}
		}
	}

	for (int i = 0; i < N; i++) {
		gStart = i;
		for (int j = 0; j < N; j++) {
			gEnd = j;
			memset(visit, 0, sizeof(visit));
			found = 0;
			dfs(i);
			cout << found << " ";
		}
		cout << endl;
	}
}
