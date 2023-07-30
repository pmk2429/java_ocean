package hard;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * You have information about n different recipes. You are given a string array recipes and a 2D string array
 * ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients
 * from ingredients[i]. Ingredients to a recipe may need to be created from other recipes, i.e., ingredients[i] may
 * contain a string that is in recipes.
 * You are also given a string array supplies containing all the ingredients that you initially have, and you have an
 * infinite supply of all of them.
 * Return a list of all the recipes that you can create. You may return the answer in any order.
 * Note that two recipes may contain each other in their ingredients.
 * <p>
 * Example 1:
 * ----------
 * Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
 * Output: ["bread"]
 * Explanation:
 * We can create "bread" since we have the ingredients "yeast" and "flour".
 * <p>
 * Example 2:
 * ----------
 * Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
 * Output: ["bread","sandwich"]
 * Explanation:
 * We can create "bread" since we have the ingredients "yeast" and "flour".
 * We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
 * <p>
 * Example 3:
 * ----------
 * Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
 * Output: ["bread","sandwich","burger"]
 * Explanation:
 * We can create "bread" since we have the ingredients "yeast" and "flour".
 * We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
 * We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".
 * <p>
 * Constraints:
 * ------------
 * n == recipes.length == ingredients.length
 * 1 <= n <= 100
 * 1 <= ingredients[i].length, supplies.length <= 100
 * 1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
 * recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase English letters.
 * All the values of recipes and supplies combined are unique.
 * Each ingredient[i] does not contain any duplicate values.
 */
public class RecipesFromSupplies {
    private static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        // Put all supplies into HashSet.
        Set<String> available = Arrays.stream(supplies).collect(Collectors.toSet());
        Map<String, Set<String>> ingredientToRecipes = new HashMap<>();

        Map<String, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < recipes.length; ++i) {
            int nonAvailable = 0;
            for (String ing : ingredients.get(i)) {
                if (!available.contains(ing)) {
                    ingredientToRecipes.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
                    ++nonAvailable;
                }
            }
            if (nonAvailable == 0) {
                ans.add(recipes[i]);
            }
            else {
                inDegree.put(recipes[i], nonAvailable);
            }
        }

        // Toplogical Sort
        for (int i = 0; i < ans.size(); ++i) {
            String recipe = ans.get(i);
            if (ingredientToRecipes.containsKey(recipe)) {
                for (String rcp : ingredientToRecipes.remove(recipe)) {
                    if (inDegree.merge(rcp, -1, Integer::sum) == 0) {
                        ans.add(rcp);
                    }
                }
            }
        }
        return ans;
    }

    private static List<String> getAllRecipes1() {
        String[] recipes = {"bread", "sandwich"};
        String[] supplies = {"yeast", "flour", "meat"};
        List<List<String>> ingredients = new ArrayList<>() {{
            add(Arrays.asList("yeast", "flour"));
            add(Arrays.asList("bread", "meat"));
        }};
        return findAllRecipes(recipes, ingredients, supplies);
    }

    private static List<String> getAllRecipes2() {
        String[] recipes = {"bread", "sandwich", "burger"};
        String[] supplies = {"yeast", "flour", "meat"};
        List<List<String>> ingredients = new ArrayList<>() {{
            add(Arrays.asList("yeast", "flour"));
            add(Arrays.asList("bread", "meat"));
            add(Arrays.asList("sandwich", "meat", "bread"));
        }};
        return findAllRecipes(recipes, ingredients, supplies);
    }

    public static void main(String[] args) {
        System.out.println(getAllRecipes1());
        System.out.println(getAllRecipes2());
    }
}
