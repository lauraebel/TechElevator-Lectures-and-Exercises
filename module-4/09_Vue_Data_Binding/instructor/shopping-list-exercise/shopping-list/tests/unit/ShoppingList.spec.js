import ShoppingList from '@/components/ShoppingList';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ShoppingList', () => {

    /** @type Wrapper */
    let wrapper;

    beforeEach( () => {
        wrapper = shallowMount(ShoppingList);
    });

    it('should render a single shopping list item to the unordered list', () => {
        const groceries = [{item: 'Milk', completed: false}];
        wrapper.setData({groceries});
        wrapper.findAll('li').length.should.equal(1);
    })

    it('should contain 9 items', () => {
        const groceries = [
            { item: 'Oatmeal', completed: false },
            { item: 'Milk', completed: false },
            { item: 'Banana', completed: false },
            { item: 'Strawberries', completed: false },
            { item: 'Lunch Meat', completed: false },
            { item: 'Bread', completed: false },
            { item: 'Grapes', completed: false },
            { item: 'Steak', completed: false },
            { item: 'Salad', completed: false }
        ];
        wrapper.setData({groceries});
        wrapper.findAll('li').length.should.equal(9);
    })

    it('should contain 3 items with class completed', () => {
        const groceries = [
            { item: 'Oatmeal', completed: true },
            { item: 'Milk', completed: true },
            { item: 'Banana', completed: true },
            { item: 'Strawberries', completed: false },
            { item: 'Lunch Meat', completed: false },
            { item: 'Bread', completed: false },
            { item: 'Grapes', completed: false },
            { item: 'Steak', completed: false },
            { item: 'Salad', completed: false }
        ];
        wrapper.setData({groceries});
        wrapper.findAll('li.completed').length.should.equal(3);
    })

});