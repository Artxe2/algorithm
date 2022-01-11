const backtracking = "backtracking";
const bestFirstSearch = "best first search";
const BFS_breadthFirstSearch = "BFS(breadth first search)";
const binarySearch = "binary search";
const binaryTree = "binary tree";
const DFS_depthFirstSearch = "DFS(depth first search)";
const dijkstra = "dijkstra";
const DP_dynamicProgramming = "DP(dynamic programming)";
const euclideanAlgorithm = "euclidean algorithm";
const fibonacci = "fibonacci";
const graph = "graph";
const greedyAlgorithm = "greedy algorithm";
const hashSet = "hash set";
const parametricSearch = "parametric search";
const priorityQueue = "priority queue";
const simulation = "simulation";
const slidingWindow = "sliding window";
const sort = "sort";
const twoPointers = "two pointers";
const recursion = "recursion"

const list = {
    java: {
        programmers: {
            kakao_level_5: [
            ]
            , kakao_level_4: [
                [ "4단 고음", backtracking ]
            ]
            , kakao_level_3: [
                [ "[1차] 셔틀버스", simulation ]
                , [ "[1차] 추석 트래픽", simulation ]
                , [ "기둥과 보 설치", simulation ]
                , [ "경주로 건설", BFS_breadthFirstSearch ]
                , [ "리틀 프렌즈 사천성", greedyAlgorithm ]
                , [ "보석 쇼핑", twoPointers ]
                , [ "보행자 천국", DP_dynamicProgramming ]
                , [ "불량 사용자", DFS_depthFirstSearch ]
                , [ "브라이언의 고민", simulation ]
                , [ "외벽 점검", backtracking ]
                , [ "자물쇠와 열쇠", simulation ]
                , [ "표 편집", simulation ]
                , [ "합승 택시 요금", dijkstra ]
                , [ "GPS", DP_dynamicProgramming ]
            ]
            , kakao_level_2: [
                [ "[1차] 뉴스 클러스터링", simulation ]
                , [ "[1차] 캐시", simulation ]
                , [ "[1차] 프렌즈4블록", simulation ]
                , [ "[3차] 방금그곡", simulation ]
                , [ "[3차] 압축", simulation ]
                , [ "[3차] 파일명 정렬", simulation ]
                , [ "[3차] n진수 게임", recursion ]
                , [ "괄호 변환", recursion ]
                , [ "거리두기 확인하기", simulation ]
                , [ "단체사진 찍기", backtracking ]
                , [ "메뉴 리뉴얼", backtracking ]
                , [ "문자열 압축", simulation ]
                , [ "수식 최대화", DFS_depthFirstSearch ]
                , [ "순위 검색", parametricSearch ]
                , [ "오픈채팅방", simulation ]
                , [ "카카오프렌즈 컬러링북", DFS_depthFirstSearch ]
                , [ "튜플", simulation ]
                , [ "후보키", BFS_breadthFirstSearch ]
            ]
            , kakao_level_1: [
                [ "[1차] 다트 게임", simulation ]
                , [ "[1차] 비밀 지도", simulation ]
                , [ "숫자 문자열과 영단어", simulation ]
                , [ "신규 아이디 추천", simulation ]
                , [ "실패율", simulation ]
                , [ "크레인 인형뽑기 게임", simulation ]
                , [ "키패드 누르기", simulation ]
            ]
            , level_5: [
                [ "방의 개수", simulation ]
            ]
            , level_4: [
                [ "도둑질", DP_dynamicProgramming ]
                , [ "지형 이동", BFS_breadthFirstSearch ]
                , [ "징검다리", parametricSearch ]
            ]
            , level_3: [
                [ "110 옮기기", simulation ]
                , [ "2 x n 타일링", fibonacci, DP_dynamicProgramming ]
                , [ "가장 긴 팰린드롬", simulation ]
                , [ "가장 먼 노드", graph, BFS_breadthFirstSearch ]
                , [ "광고 삽입", slidingWindow ]
                , [ "거스름돈", DP_dynamicProgramming ]
                , [ "공 이동 시뮬레이션", simulation ]
                , [ "금과 은 운반하기", parametricSearch ]
                , [ "길 찾기 게임", binaryTree, DFS_depthFirstSearch, sort ]
                , [ "네트워크", DFS_depthFirstSearch ]
                , [ "다단계 칫솔 판매", simulation ]
                , [ "단속카메라", simulation ]
                , [ "단어 변환", simulation ]
                , [ "등굣길", DP_dynamicProgramming ]
                , [ "디스크 컨트롤러", simulation ]
                , [ "멀리 뛰기", fibonacci, DP_dynamicProgramming ]
                , [ "모두 0으로 만들기", graph, DP_dynamicProgramming ]
                , [ "섬 연결하기", simulation ]
                , [ "순위", simulation ]
                , [ "숫자 게임", sort ]
                , [ "스티커 모으기(2)", simulation ]
                , [ "베스트앨범", simulation ]
                , [ "아이템 줍기", simulation ]
                , [ "야근 지수", priorityQueue ]
                , [ "여행경로", bestFirstSearch ]
                , [ "이중우선순위큐", parametricSearch ]
                , [ "입국심사", parametricSearch ]
                , [ "정수 삼각형", DP_dynamicProgramming ]
                , [ "줄 서는 방법", recursion ]
                , [ "징검다리 건너기", parametricSearch ]
                , [ "최고의 집합", simulation ]
                , [ "풍선 터뜨리기", simulation ]
                , [ "퍼즐 조각 채우기", DFS_depthFirstSearch ]
                , [ "하노이의 탑", recursion ]
                , [ "N-Queen", backtracking ]
                , [ "N으로 표현", backtracking ]
            ]
            , level_2: [
                [ "124 나라의 숫자", recursion ]
                , [ "2개 이하로 다른 비트", simulation ]
                , [ "가장 큰 수", simulation ]
                , [ "가장 큰 정사각형 찾기", DP_dynamicProgramming ]
                , [ "게임 맵 최단거리", BFS_breadthFirstSearch ]
                , [ "괄호 회전하기", simulation ]
                , [ "교점에 별 만들기", simulation ]
                , [ "구명보트", twoPointers ]
                , [ "기능개발", simulation ]
                , [ "다리를 지나는 트럭", simulation ]
                , [ "다음 큰 숫자", simulation ]
                , [ "더 맵게", priorityQueue ]
                , [ "땅따먹기", simulation ]
                , [ "멀쩡한 사각형", euclideanAlgorithm ]
                , [ "모음 사전", simulation ]
                , [ "방문 길이", simulation ]
                , [ "배달", dijkstra ]
                , [ "빛의 경로 사이클", simulation ]
                , [ "삼각 달팽이", simulation ]
                , [ "소수 찾기", DFS_depthFirstSearch ]
                , [ "숫자의 표현", simulation ]
                , [ "스킬트리", simulation ]
                , [ "영어 끝말잇기", simulation ]
                , [ "예상 대진표", simulation ]
                , [ "올바른 괄호", simulation ]
                , [ "위장", simulation ]
                , [ "이진 변환 반복하기", simulation ]
                , [ "전력망을 둘로 나누기", DFS_depthFirstSearch ]
                , [ "전화번호 목록", simulation ]
                , [ "점프와 순간 이동", simulation ]
                , [ "조이스틱", simulation ]
                , [ "주식가격", simulation ]
                , [ "짝지어 제거하기", simulation ]
                , [ "최댓값과 최솟값", simulation ]
                , [ "최솟값 만들기", simulation ]
                , [ "카펫", binarySearch ]
                , [ "쿼드압축 후 개수 세기", DFS_depthFirstSearch ]
                , [ "큰 수 만들기", greedyAlgorithm ]
                , [ "타겟 넘버", DFS_depthFirstSearch ]
                , [ "프린터", simulation ]
                , [ "피로도", bestFirstSearch ]
                , [ "피보나치 수", fibonacci, DP_dynamicProgramming ]
                , [ "행렬 테두리 회전하기", simulation ]
                , [ "행렬의 곱셈", simulation ]
                , [ "H-Index", parametricSearch ]
                , [ "JadenCase 문자열 만들기", simulation ]
                , [ "n^2 배열 자르기", simulation ]
                , [ "N개의 최소공배수", euclideanAlgorithm ]
            ]
            , level_1: [
                [ "2016년", simulation ]
                , [ "3진법 뒤집기", recursion ]
                , [ "가운데 글자 가져오기", simulation ]
                , [ "같은 숫자는 싫어", simulation ]
                , [ "나누어 떨어지는 숫자 배열", sort ]
                , [ "나머지가 1이 되는 수 찾기", simulation ]
                , [ "내적", simulation ]
                , [ "두 개 뽑아서 더하기", hashSet, sort ]
                , [ "두 정수 사이의 합", simulation ]
                , [ "로또의 최고 순위와 최저 순위", simulation ]
                , [ "모의고사", simulation ]
                , [ "문자열 내 마음대로 정렬하기", sort ]
                , [ "문자열 내 p와 y의 개수", simulation ]
                , [ "문자열 내림차순으로 배치하기", sort ]
                , [ "문자열 다루기 기본", simulation ]
                , [ "문자열을 정수로 바꾸기", simulation ]
                , [ "부족한 금액 계산하기", simulation ]
                , [ "서울에서 김서방 찾기", simulation ]
                , [ "소수 만들기", simulation ]
                , [ "소수 찾기", simulation ]
                , [ "수박수박수박수박수박수?", simulation ]
                , [ "시저 암호", simulation ]
                , [ "약수의 개수와 덧셈", simulation ]
                , [ "약수의 합", simulation ]
                , [ "없는 숫자 더하기", simulation ]
                , [ "예산", simulation ]
                , [ "완주하지 못한 선수", sort ]
                , [ "음양 더하기", simulation ]
                , [ "이상한 문자 만들기", simulation ]
                , [ "자릿수 더하기", simulation ]
                , [ "자연수 뒤집어 배열로 만들기", recursion ]
                , [ "정수 내림차순으로 배치하기", sort ]
                , [ "정수 제곱근 판별", simulation ]
                , [ "제일 작은 수 제거하기", simulation ]
                , [ "직사각형 별찍기", simulation ]
                , [ "짝수와 홀수", simulation ]
                , [ "체육복", simulation ]
                , [ "최대공약수와 최소공배수", euclideanAlgorithm ]
                , [ "최소직사각형", simulation ]
                , [ "콜라츠 추측", simulation ]
                , [ "평균 구하기", simulation ]
                , [ "폰켓몬", simulation ]
                , [ "하샤드 수", simulation ]
                , [ "핸드폰 번호 가리기", simulation ]
                , [ "행렬의 덧셈", simulation ]
                , [ "K번째수", simulation ]
                , [ "x만큼 간격이 있는 n개의 숫자", simulation ]
            ]
        }
        , leetcode: {
            hard: [

            ]
            , medium: [

            ]
            , easy: [
                [ "1.Two Sum", simulation ]
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
