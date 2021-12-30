const algorithm = {
    backtracking: "backtracking"
    , BFS_breadthFirstSearch: "BFS(breadth first search)"
    , binarySearch: "binary search"
    , dijkstra: "dijkstra"
    , DP_dynamicProgramming: "DP(dynamic programming)"
    , parametricSearch: "parametricSearch"
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
                [ "경주로-건설", algorithm.BFS_breadthFirstSearch ]
                , [ "합승-택시-요금", algorithm.dijkstra ]
                , [ "GPS", algorithm.DP_dynamicProgramming ]
            ]
            , kakao_level_2: [
                [ "메뉴-리뉴얼", algorithm.backtracking ]
                , [ "순위-검색", algorithm.parametricSearch ]
                , [ "후보키", algorithm.BFS_breadthFirstSearch ]
            ]
            , kakao_level_1: [
                [ "[1차]-다트-게임", algorithm.simulation ]
                , [ "숫자-문자열과-영단어", algorithm.simulation ]
                , [ "신규-아이디-추천", algorithm.simulation ]
                , [ "크레인-인형뽑기-게임", algorithm.simulation ]
                , [ "키패드-누르기", algorithm.simulation ]
            ]
            , level_5: [
                [ "방의-개수", algorithm.simulation ]
            ]
            , level_4: [
                [ "도둑질", algorithm.DP_dynamicProgramming ]
                , [ "지형-이동", algorithm.BFS_breadthFirstSearch ]
                , [ "징검다리", algorithm.parametricSearch ]
            ]
            , level_3: [
                [ "가장-먼-노드", algorithm.BFS_breadthFirstSearch ]
                , [ "금과-은-운반하기", algorithm.parametricSearch ]
                , [ "이중우선순위큐", algorithm.parametricSearch ]
            ]
            , level_2: [
                [ "게임-맵-최단거리", algorithm.BFS_breadthFirstSearch ]
                , [ "방문-길이", algorithm.simulation ]
                , [ "카펫", algorithm.binarySearch ]
            ]
            , level_1: [
            ]
        }
        , algorithm: [
            "Backtracking.java"
            , "MergeSort.java"
            , "ParametricSearch.java"
            , "PriorityQueue.java"
            , "QuickSort.java"
        ]
    }
};