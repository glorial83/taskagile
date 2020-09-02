import { mount, shallowMount } from "@vue/test-utils";
import RegisterPage from "@/views/RegisterPage.vue";

describe("RegisterPage.vue", () => {
  let wrapper;
  let fieldUsername;
  let fieldEmailAddress;
  let fieldPassword;
  let buttonSubmit;
  let registerSpy;

  beforeEach(() => {
    wrapper = mount(RegisterPage);
    fieldUsername = wrapper.find("#username");
    fieldEmailAddress = wrapper.find("#emailAddress");
    fieldPassword = wrapper.find("#password");
    buttonSubmit = wrapper.find('form button[type="submit"]');
  });

  it("should render registration form", () => {
    expect(wrapper.find(".logo").attributes().src).toEqual(
      "/static/images/logo.png"
    );
    expect(wrapper.find(".tagline").text()).toEqual(
      "Open Source task management tool"
    );
    expect(fieldUsername.element.value).toEqual("");
    expect(fieldEmailAddress.element.value).toEqual("");
    expect(fieldPassword.element.value).toEqual("");
    expect(buttonSubmit.text()).toEqual("Create Account");
  });

  it("should contain data model with initial values", () => {
    expect(wrapper.vm.form.username).toEqual("");
    expect(wrapper.vm.form.emailAddress).toEqual("");
    expect(wrapper.vm.form.password).toEqual("");
  });

  it("should have form inputs bound with data model", async () => {
    let data = {
      form: {
        username: "sunny",
        emailAddress: "sunny@local",
        password: "VueJsRocks!"
      }
    };

    await wrapper.setData(data);

    expect(fieldUsername.element.value).toEqual(data.form.username);
    expect(fieldEmailAddress.element.value).toEqual(data.form.emailAddress);
    expect(fieldPassword.element.value).toEqual(data.form.password);
  });

  it("should have form submit event handler `submitForm`", () => {
    const spySubmit = jest.spyOn(wrapper.vm, "submitForm");

    buttonSubmit.trigger("submit");
    expect(spySubmit).toHaveBeenCalled();
  });
});
