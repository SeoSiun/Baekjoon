class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree: skill_trees) {
            if (isPossible(skill, skill_tree)) answer++;
        }
        return answer;
    }
    
    private boolean isPossible(String skill, String skillTree) {
        int max = -1;
        boolean check = false;
        
        for (char c : skill.toCharArray()) {
            if (skillTree.indexOf(c) == -1) {
                check = true;
                continue;
            }
            if (check) return false;
            int curPos = skillTree.indexOf(c);
            if (curPos < max) {
                return false;
            }
            max = curPos;
        }
        return true;
    }
}