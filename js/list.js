const algorithm = {
    backtracking: "backtracking"
    , BFS_breadthFirstSearch: "BFS(breadth first search)"
    , binarySearch: "binary search"
    , dijkstra: "dijkstra"
    , DP_dynamicProgramming: "DP(dynamic programming)"
    , simulation: "simulation"
};
const list = {
    java: {
        programmers: {
            kakao_level_5: [
            ]
            , kakao_level_4: [
                [ "4단-고음", algorithm.backtracking ]
            ]
            , kakao_level_3: [
                [ "합승-택시-요금", algorithm.dijkstra ]
                , [ "GPS", algorithm.DP_dynamicProgramming ]
            ]
            , kakao_level_2: [
                [ "메뉴-리뉴얼", algorithm.backtracking ]
            ]
            , kakao_level_1: [
            ]
            , level_5: [
                [ "방의-개수", algorithm.simulation ]
            ]
            , level_4: [
                [ "도둑질", algorithm.DP_dynamicProgramming ]
                , [ "지형-이동", algorithm.BFS_breadthFirstSearch ]
            ]
            , level_3: [
            ]
            , level_2: [
                [ "방문-길이", algorithm.simulation ]
                , [ "카펫", algorithm.binarySearch ]
            ]
            , level_1: [
            ]
        }
        , algorithm: [
            "Quick-sort"
        ]
    }
};