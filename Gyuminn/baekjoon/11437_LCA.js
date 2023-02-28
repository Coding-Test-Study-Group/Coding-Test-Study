// https://www.acmicpc.net/problem/11437
// LCA

// 백준 입력을 받기 위한 변수
let N = 0;
let M = 0;
const input = [];

// 풀이
const sol = (input) => {
  // 연결된 정점들
  const connectedVertexes = input.slice(1, N);
  // 공통 부모를 알고 싶은 정점 쌍
  const pairOfVertexes = input.slice(N + 1);

  // graph 관계를 위한 인접 리스트 생성
  const graph = Array.from(Array(N + 1), () => Array());
  for (let [a, b] of connectedVertexes) {
    graph[a].push(b);
    graph[b].push(a);
  }

  // 각 정점의 부모 노드를 저장할 배열, root 노드의 부모는 1으로 초기화
  const parent = Array.from({ length: N + 1 }, () => 0);
  parent[1] = 1;

  // 각 정점의 depth를 저장할 배열
  const depth = Array.from({ length: N + 1 }, () => -1);

  // 모든 노드의 부모 노드와 depth를 구하기 위한 DFS.
  const dfsForParentAndDepth = (node, dist) => {
    depth[node] = dist;

    // 인접 리스트를 순회
    for (let nextNode of graph[node]) {
      // 다음 탐색하는 노드의 깊이가 정해져있지 않을 경우
      if (depth[nextNode] === -1) {
        dfsForParentAndDepth(nextNode, dist + 1);
        // 돌아오면서 부모 노드를 저장
        parent[nextNode] = node;
      }
    }
  };

  // root node인 1번 정점에서 시작, depth는 0으로 초기화
  dfsForParentAndDepth(1, 0);

  const result = [];

  // LCA 핵심 로직.
  // 1. 두 정점의 depth가 같아질 때까지 더 깊은 정점을 올린다.
  // 2. 두 정점에서 하나씩 부모 정점으로 올라가며 같은 지점을 찾는다.
  for (let [a, b] of pairOfVertexes) {
    let depthOfA = depth[a];
    let depthOfB = depth[b];

    if (depthOfA > depthOfB) {
      while (depthOfA !== depthOfB) {
        depthOfA--;
        a = parent[a];
      }
    }

    if (depthOfA < depthOfB) {
      while (depthOfA !== depthOfB) {
        depthOfB--;
        b = parent[b];
      }
    }

    while (a !== b) {
      a = parent[a];
      b = parent[b];
    }

    result.push(a);
  }
  return result.join(`\n`);
};

// 백준 입력을 받기 위한 코드
require("readline")
  .createInterface({
    input: process.stdin,
    output: process.stdout,
  })
  .on("line", (line) => {
    if (input.length === 0) {
      N = +line;
    }
    input.push(line.split(" ").map((v) => +v));

    if (input.length === N + 1) {
      M = +line;
    }

    if (input.length === N + M + 1) {
      console.log(sol(input));
      process.exit();
    }
  });
