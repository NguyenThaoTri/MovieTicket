    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
     */
    package project.sem4.movie.service;

    import java.util.List;
    import project.sem4.movie.entities.Branchs;

    /**
     *
     * @author NTT
     */
    public interface BranchService {
        List<Branchs> getAllBranchs();

        Branchs getBranchById(int branch_id);

        Branchs pushBranch(Branchs newBranch);

        Branchs updateBranch(Branchs updateBranch, int branch_id);

        void deleteBranchById(int branch_id);
    }
