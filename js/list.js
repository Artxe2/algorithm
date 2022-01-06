const algorithm = {
    backtracking: "backtracking"
    , bestFirstSearch: "best first search"
    , BFS_breadthFirstSearch: "BFS(breadth first search)"
    , binarySearch: "binary search"
    , DFS_depthFirstSearch: "DFS(depth first search)"
    , dijkstra: "dijkstra"
    , DP_dynamicProgramming: "DP(dynamic programming)"
    , euclideanAlgorithm: "euclidean algorithm"
    , greedyAlgorithm: "greedy algorithm"
    , parametricSearch: "parametric search"
    , priorityQueue: "priority queue"
    , simulation: "simulation"
    , slidingWindow: "sliding window"
    , twoPointer: "two pointer"
    , recursion: "recursion"
};
const list = {
    java: {
        programmers: {
            kakao_level_5: [
            ]
            , kakao_level_4: [
                [ "4단 고음", algorithm.backtracking ]
            ]
            , kakao_level_3: [
                [ "[1차] 셔틀버스", algorithm.simulation ]
                , [ "[1차] 추석 트래픽", algorithm.simulation ]
                , [ "기둥과 보 설치", algorithm.simulation ]
                , [ "경주로 건설", algorithm.BFS_breadthFirstSearch ]
                , [ "리틀 프렌즈 사천성", algorithm.greedyAlgorithm ]
                , [ "보석 쇼핑", algorithm.twoPointer ]
                , [ "보행자 천국", algorithm.DP_dynamicProgramming ]
                , [ "불량 사용자", algorithm.DFS_depthFirstSearch ]
                , [ "브라이언의 고민", algorithm.simulation ]
                , [ "외벽 점검", algorithm.backtracking ]
                , [ "자물쇠와 열쇠", algorithm.simulation ]
                , [ "표 편집", algorithm.simulation ]
                , [ "합승 택시 요금", algorithm.dijkstra ]
                , [ "GPS", algorithm.DP_dynamicProgramming ]
            ]
            , kakao_level_2: [
                [ "[1차] 뉴스 클러스터링", algorithm.simulation ]
                , [ "[1차] 캐시", algorithm.simulation ]
                , [ "[1차] 프렌즈4블록", algorithm.simulation ]
                , [ "[3차] 방금그곡", algorithm.simulation ]
                , [ "[3차] 압축", algorithm.simulation ]
                , [ "[3차] 파일명 정렬", algorithm.simulation ]
                , [ "[3차] n진수 게임", algorithm.recursion ]
                , [ "괄호 변환", algorithm.recursion ]
                , [ "거리두기 확인하기", algorithm.simulation ]
                , [ "단체사진 찍기", algorithm.backtracking ]
                , [ "메뉴 리뉴얼", algorithm.backtracking ]
                , [ "문자열 압축", algorithm.simulation ]
                , [ "수식 최대화", algorithm.DFS_depthFirstSearch ]
                , [ "순위 검색", algorithm.parametricSearch ]
                , [ "오픈채팅방", algorithm.simulation ]
                , [ "카카오프렌즈 컬러링북", algorithm.DFS_depthFirstSearch ]
                , [ "튜플", algorithm.simulation ]
                , [ "후보키", algorithm.BFS_breadthFirstSearch ]
            ]
            , kakao_level_1: [
                [ "[1차] 다트 게임", algorithm.simulation ]
                , [ "[1차] 비밀 지도", algorithm.simulation ]
                , [ "숫자 문자열과 영단어", algorithm.simulation ]
                , [ "신규 아이디 추천", algorithm.simulation ]
                , [ "실패율", algorithm.simulation ]
                , [ "크레인 인형뽑기 게임", algorithm.simulation ]
                , [ "키패드 누르기", algorithm.simulation ]
            ]
            , level_5: [
                [ "방의 개수", algorithm.simulation ]
            ]
            , level_4: [
                [ "도둑질", algorithm.DP_dynamicProgramming ]
                , [ "지형 이동", algorithm.BFS_breadthFirstSearch ]
                , [ "징검다리", algorithm.parametricSearch ]
            ]
            , level_3: [
                [ "2 x n 타일링", algorithm.DP_dynamicProgramming ]
                , [ "가장 긴 팰린드롬", algorithm.simulation ]
                , [ "가장 먼 노드", algorithm.BFS_breadthFirstSearch ]
                , [ "광고 삽입", algorithm.slidingWindow ]
                , [ "금과 은 운반하기", algorithm.parametricSearch ]
                , [ "네트워크", algorithm.DFS_depthFirstSearch ]
                , [ "다단계 칫솔 판매", algorithm.simulation ]
                , [ "단속카메라", algorithm.simulation ]
                , [ "단어 변환", algorithm.simulation ]
                , [ "등굣길", algorithm.DP_dynamicProgramming ]
                , [ "디스크 컨트롤러", algorithm.simulation ]
                , [ "섬 연결하기", algorithm.simulation ]
                , [ "순위", algorithm.simulation ]
                , [ "스티커 모으기(2)", algorithm.simulation ]
                , [ "베스트앨범", algorithm.simulation ]
                , [ "아이템 줍기", algorithm.simulation ]
                , [ "야근 지수", algorithm.priorityQueue ]
                , [ "여행경로", algorithm.bestFirstSearch ]
                , [ "이중우선순위큐", algorithm.parametricSearch ]
                , [ "입국심사", algorithm.parametricSearch ]
                , [ "정수 삼각형", algorithm.DP_dynamicProgramming ]
                , [ "줄 서는 방법", algorithm.recursion ]
                , [ "징검다리 건너기", algorithm.parametricSearch ]
                , [ "최고의 집합", algorithm.simulation ]
                , [ "풍선 터뜨리기", algorithm.simulation ]
                , [ "퍼즐 조각 채우기", algorithm.DFS_depthFirstSearch ]
                , [ "하노이의 탑", algorithm.recursion ]
                , [ "N-Queen", algorithm.backtracking ]
                , [ "N으로 표현", algorithm.backtracking ]
            ]
            , level_2: [
                [ "124 나라의 숫자", algorithm.recursion ]
                , [ "2개 이하로 다른 비트", algorithm.simulation ]
                , [ "가장 큰 수", algorithm.simulation ]
                , [ "가장 큰 정사각형 찾기", algorithm.DP_dynamicProgramming ]
                , [ "게임 맵 최단거리", algorithm.BFS_breadthFirstSearch ]
                , [ "괄호 회전하기", algorithm.simulation ]
                , [ "교점에 별 만들기", algorithm.simulation ]
                , [ "구명보트", algorithm.twoPointer ]
                , [ "기능개발", algorithm.simulation ]
                , [ "다리를 지나는 트럭", algorithm.simulation ]
                , [ "다음 큰 숫자", algorithm.simulation ]
                , [ "더 맵게", algorithm.priorityQueue ]
                , [ "땅따먹기", algorithm.simulation ]
                , [ "멀쩡한 사각형", algorithm.euclideanAlgorithm ]
                , [ "모음 사전", algorithm.simulation ]
                , [ "방문 길이", algorithm.simulation ]
                , [ "배달", algorithm.dijkstra ]
                , [ "빛의 경로 사이클", algorithm.simulation ]
                , [ "삼각 달팽이", algorithm.simulation ]
                , [ "소수 찾기", algorithm.DFS_depthFirstSearch ]
                , [ "숫자의 표현", algorithm.simulation ]
                , [ "스킬트리", algorithm.simulation ]
                , [ "영어 끝말잇기", algorithm.simulation ]
                , [ "예상 대진표", algorithm.simulation ]
                , [ "올바른 괄호", algorithm.simulation ]
                , [ "위장", algorithm.simulation ]
                , [ "이진 변환 반복하기", algorithm.simulation ]
                , [ "전력망을 둘로 나누기", algorithm.DFS_depthFirstSearch ]
                , [ "전화번호 목록", algorithm.simulation ]
                , [ "점프와 순간 이동", algorithm.simulation ]
                , [ "조이스틱", algorithm.simulation ]
                , [ "주식가격", algorithm.simulation ]
                , [ "짝지어 제거하기", algorithm.simulation ]
                , [ "최댓값과 최솟값", algorithm.simulation ]
                , [ "최솟값 만들기", algorithm.simulation ]
                , [ "카펫", algorithm.binarySearch ]
                , [ "쿼드압축 후 개수 세기", algorithm.DFS_depthFirstSearch ]
                , [ "큰 수 만들기", algorithm.greedyAlgorithm ]
                , [ "타겟 넘버", algorithm.DFS_depthFirstSearch ]
                , [ "프린터", algorithm.simulation ]
                , [ "피로도", algorithm.bestFirstSearch ]
                , [ "피보나치 수", algorithm.DP_dynamicProgramming ]
                , [ "행렬 테두리 회전하기", algorithm.simulation ]
                , [ "행렬의 곱셈", algorithm.simulation ]
                , [ "H-Index", algorithm.parametricSearch ]
                , [ "JadenCase 문자열 만들기", algorithm.simulation ]
                , [ "n^2 배열 자르기", algorithm.simulation ]
                , [ "N개의 최소공배수", algorithm.euclideanAlgorithm ]
            ]
            , level_1: [
                [ "2016년", algorithm.simulation ]
                , [ "3진법 뒤집기", algorithm.recursion ]
                , [ "가운데 글자 가져오기", algorithm.simulation ]
                , [ "같은 숫자는 싫어", algorithm.simulation ]
                , [ "나누어 떨어지는 숫자 배열", algorithm.simulation ]
                , [ "나머지가 1이 되는 수 찾기", algorithm.simulation ]
                , [ "내적", algorithm.simulation ]
                , [ "두 개 뽑아서 더하기", algorithm.simulation ]
                , [ "두 정수 사이의 합", algorithm.simulation ]
                , [ "로또의 최고 순위와 최저 순위", algorithm.simulation ]
                , [ "모의고사", algorithm.simulation ]
                , [ "문자열 내 마음대로 정렬하기", algorithm.simulation ]
                , [ "문자열 내 p와 y의 개수", algorithm.simulation ]
                , [ "문자열 내림차순으로 배치하기", algorithm.simulation ]
                , [ "문자열 다루기 기본", algorithm.simulation ]
                , [ "문자열을 정수로 바꾸기", algorithm.simulation ]
                , [ "부족한 금액 계산하기", algorithm.simulation ]
                , [ "서울에서 김서방 찾기", algorithm.simulation ]
                , [ "소수 만들기", algorithm.simulation ]
                , [ "소수 찾기", algorithm.simulation ]
                , [ "수박수박수박수박수박수?", algorithm.simulation ]
                , [ "시저 암호", algorithm.simulation ]
                , [ "약수의 개수와 덧셈", algorithm.simulation ]
                , [ "약수의 합", algorithm.simulation ]
                , [ "없는 숫자 더하기", algorithm.simulation ]
                , [ "예산", algorithm.simulation ]
                , [ "완주하지 못한 선수", algorithm.simulation ]
                , [ "음양 더하기", algorithm.simulation ]
                , [ "이상한 문자 만들기", algorithm.simulation ]
                , [ "자릿수 더하기", algorithm.simulation ]
                , [ "자연수 뒤집어 배열로 만들기", algorithm.simulation ]
                , [ "정수 내림차순으로 배치하기", algorithm.simulation ]
                , [ "정수 제곱근 판별", algorithm.simulation ]
                , [ "제일 작은 수 제거하기", algorithm.simulation ]
                , [ "직사각형 별찍기", algorithm.simulation ]
                , [ "짝수와 홀수", algorithm.simulation ]
                , [ "체육복", algorithm.simulation ]
                , [ "최대공약수와 최소공배수", algorithm.euclideanAlgorithm ]
                , [ "최소직사각형", algorithm.simulation ]
                , [ "콜라츠 추측", algorithm.simulation ]
                , [ "평균 구하기", algorithm.simulation ]
                , [ "폰켓몬", algorithm.simulation ]
                , [ "하샤드 수", algorithm.simulation ]
                , [ "핸드폰 번호 가리기", algorithm.simulation ]
                , [ "행렬의 덧셈", algorithm.simulation ]
                , [ "K번째수", algorithm.simulation ]
                , [ "x만큼 간격이 있는 n개의 숫자", algorithm.simulation ]
            ]
        }
        , leetcode: {
            hard: [

            ]
            , medium: [

            ]
            , easy: [
                [ "1.Two Sum", algorithm.simulation ]
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
