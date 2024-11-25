class AddressDropdown {
    constructor(selector, {input}) {
        this.input = input || ".address-input";
        this.selector = selector;
    }



    render() {
        const provinceContent = document.querySelector(this.selector).querySelector(".province-content");
        const districtContent = document.querySelector(this.selector).querySelector(".district-content");
        const wardContent = document.querySelector(this.selector).querySelector(".ward-content");
        const values = []

        if (this.data) {
            const provincesItems = this.data.map((p) => {
                let item = document.createElement('button')
                item.classList.add('list-group-item', 'list-group-item-action', 'px-3', 'border-0')
                item.textContent = p.name
                item.setAttribute("p_id", p.level1_id)
                if (this.selectedProvince === p)
                    item.classList.add("active")
                item.onclick = (e) => {
                    this.selectedProvince = this.data.find((v) => v.level1_id === e.target.getAttribute('p_id'))
                    this.render()
                }
                return item
            })
            provinceContent.innerHTML = ''

            provincesItems.forEach((item) => {
                provinceContent.insertAdjacentElement("beforeend", item)

            })
        }

        //district render
        if (this.selectedProvince) {
            values.push(this.selectedProvince.name)
            const provincesDistrict = this.selectedProvince.level2s.map((d) => {
                let item = document.createElement('button')
                item.classList.add('list-group-item', 'list-group-item-action', 'px-3', 'border-0')
                item.textContent = d.name
                item.setAttribute("d_id", d.level2_id)
                if (this.selectedDistrict === d)
                    item.classList.add("active")
                item.onclick = (e) => {
                    this.selectedDistrict = this.selectedProvince.level2s.find((v) => v.level2_id === e.target.getAttribute('d_id'))
                    console.log(this.selectedProvince)
                    console.log(this.selectedDistrict)

                    this.render()
                }
                return item
            })
            districtContent.innerHTML = ''

            provincesDistrict.forEach((item) => {
                districtContent.insertAdjacentElement("beforeend", item)

            })
        }

        if (this.selectedDistrict) {
            values.push(this.selectedDistrict.name)
            console.log(this.selectedDistrict)
            const wardItems = this.selectedDistrict.level3s.map((w) => {
                let item = document.createElement('button')
                item.classList.add('list-group-item', 'list-group-item-action', 'px-3', 'border-0')
                item.textContent = w.name
                item.setAttribute("w_id", w.level3_id)
                if (this.selectedWard === w)
                    item.classList.add("active")
                item.onclick = (e) => {
                    this.selectedWard = this.selectedDistrict.level3s.find((v) => v.level3_id === e.target.getAttribute('w_id'))
                    this.render()
                }
                return item
            })
            wardContent.innerHTML = ''

            wardItems.forEach((item) => {
                wardContent.insertAdjacentElement("beforeend", item)

            })
        }
        if (this.selectedWard)
            values.push(this.selectedWard.name)

        const inputEl = document.querySelector(`${this.selector} ${this.input}`);
        inputEl.value = values.join("/")

    }

    init() {
        const container = document.querySelector(this.selector);
        container.innerHTML = this.template;
        const element = document.querySelector(this.selector + ' .dropdown-toggle');
        const instance = new mdb.Dropdown(element);
        const triggerTabList = [].slice.call(document.querySelectorAll(this.selector + ' .nav-tabs a'));
        triggerTabList.forEach((triggerEl) => {
            const tabTrigger = new mdb.Tab(triggerEl);
            triggerEl.addEventListener('click', (event) => {
                event.preventDefault();
                tabTrigger.show();
            });
        });

        fetch("/data/dvhc.json")
            .then(value => value.json())
            .then(json => this.data = json.data)
            .then(() => {
                this.render()
            });


    }


    template = `<input class="form-control dropdown-toggle address-input" data-mdb-dropdown-init  data-mdb-auto-close="outside" aria-expanded="false">
                       <div class="dropdown-menu dropdown-menu-xl-start" style="width: 100%">
                            <div class="">
                                <ul class="nav nav-tabs nav-fill mb-3" id="ex1" role="tablist">
                                                            <li class="nav-item" role="presentation">
                                                                <a
                                                                        data-mdb-tab-init
                                                                        class="nav-link active"
                                                                        id="ex1-tab-1"
                                                                        href="#ex1-tabs-1"
                                                                        role="tab"
                                                                        aria-controls="ex1-tabs-1"
                                                                        aria-selected="true"
                                                                >Tỉnh</a
                                                                >
                                                            </li>
                                                            <li class="nav-item" role="presentation">
                                                                <a
                                                                        data-mdb-tab-init
                                                                        class="nav-link"
                                                                        id="ex1-tab-2"
                                                                        href="#ex1-tabs-2"
                                                                        role="tab"
                                                                        aria-controls="ex1-tabs-2"
                                                                        aria-selected="false"
                                                                >Quận-Huyện</a
                                                                >
                                                            </li>
                                                            <li class="nav-item" role="presentation">
                                                                <a
                                                                        data-mdb-tab-init
                                                                        class="nav-link"
                                                                        id="ex1-tab-3"
                                                                        href="#ex1-tabs-3"
                                                                        role="tab"
                                                                        aria-controls="ex1-tabs-3"
                                                                        aria-selected="false"
                                                                >Phường-Xã</a
                                                                >
                                                            </li>
                                                        </ul>
                                                        <div class="tab-content p-2" id="ex1-content">
                                                            <div
                                                                    class="tab-pane fade show active"
                                                                    id="ex1-tabs-1"
                                                                    role="tabpanel"
                                                                    aria-labelledby="ex1-tab-1"
                                                            >
                                                            <div class="list-group list-group-light overflow-y-scroll province-content" style="max-height: 320px">
                                                                
                                                            </div>
                                                            </div>
                                                            <div class="tab-pane fade" id="ex1-tabs-2" role="tabpanel" aria-labelledby="ex1-tab-2">
                                                            <div class="list-group list-group-light overflow-y-scroll district-content" style="max-height: 320px">
                                                                
                                                            </div>
                                                            </div>
                                                            <div class="tab-pane fade" id="ex1-tabs-3" role="tabpanel" aria-labelledby="ex1-tab-3">
                                                            <div class="list-group list-group-light overflow-y-scroll ward-content" style="max-height: 320px">
                                                                
                                                            </div>
                                                            </div>
                                                        </div>
                                                        <!-- Tabs content -->
                                    </div>
                                </div>


`

}