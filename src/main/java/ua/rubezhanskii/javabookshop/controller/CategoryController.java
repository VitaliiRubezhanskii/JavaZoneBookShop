package ua.rubezhanskii.javabookshop.controller;/*package ua.rubezhanskii.javabookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.datamanagement.jdbc.CategoryJdbcTemplate;
import ua.rubezhanskii.javabookshop.model.Category;

@Controller
@RequestMapping(value = "/welcome/admin/categories")
public class CategoryController {



    @Autowired
    private CategoryJdbcTemplate categoryJdbcTemplate;

    //<======================================get View with Categories==================================================>
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getCategoryPage(ModelAndView model) {
        Category category=new Category();
        model.addObject("newCategory", category);
        model.addObject("listCategories",categoryJdbcTemplate.getCategories());
        model.setViewName("addCategory");
        return model;
    }

    //<==========================================Add Category==========================================================>
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView saveOrUpdate(@ModelAttribute("category")Category category) {

        if(categoryJdbcTemplate.exists(category.getCategoryId())){
         categoryJdbcTemplate.update(category);
        }else {
            categoryJdbcTemplate.save(category);
        }
        return new ModelAndView("redirect:/welcome/rest/categories/");
    }
    //<==========================================Remove Category==========================================================>
    @RequestMapping(value = "/remove/{categoryId}")
    private ModelAndView removeCategory(@PathVariable("categoryId") Integer categoryId){
        categoryJdbcTemplate.delete(categoryId);
        return new ModelAndView("redirect:/welcome/rest/categories/");
    }
    //<==========================================Edit Category==========================================================>

    @RequestMapping("/edit/{categoryId}")
    public ModelAndView editPerson(@PathVariable("categoryId") Integer categoryId){
             Category category=categoryJdbcTemplate.getCategoryById(categoryId);
        return new ModelAndView("addCategory","newCategory",category);

    }

    @RequestMapping(value = "/edit/save",method = RequestMethod.POST)
    public ModelAndView editSave(@ModelAttribute("category") Category category){
        categoryJdbcTemplate.update(category);
        return new ModelAndView("redirect:/welcome/rest/categories/");
    }

}*/
